
import { useState } from 'react';
import { Alert, Box, Button, CircularProgress, Container, FormControl, InputLabel, MenuItem, Select, TextField, Typography } from '@mui/material'
import './App.css'
import axios from 'axios';

function App() {
  const [emailContent, setEmailContent] = useState('');
  const [tone, setTone] = useState('');
  const [generateReply, setGenerateReply] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [copied, setCopied] = useState(false);
  const handleSubmit = async () => {
    setLoading(true);
    setError('');
    try {
      const response = await axios.post("http://localhost:9999/api/email/generate", {
        emailContent,
        tone
      });
      setGenerateReply(typeof response.data === 'string' ? response.data : JSON.stringify(response.data));

    } catch (error) {
      setError("Failed to generate Email reply.Please Try Again");
      console.error(error);
    } finally {
      setLoading(false);
    }
  }

  const handleCopy = () => {

    navigator.clipboard.writeText(generateReply);
    setCopied(true);

    setTimeout(() => {
      setCopied(false);
    }, 10000);

  }

  return (
    <Container maxWidth="md" sx={{ py: 4 }}>
      <Typography varient="h3" component="h1" gutterBottom>
        Email Reply Generator
      </Typography>
      <Box sx={{ mt: 3 }}>

        <TextField
          fullWidth
          multiline
          rows={6}
          variant='outlined'
          label="Original Email Content"
          value={emailContent || ''}
          onChange={(e) => setEmailContent(e.target.value)}

        />
        <FormControl fullWidth sx={{ mt: 2,mb:2 }}>
          <InputLabel>Tone (Optional)</InputLabel>
          <Select
            value={tone || ''}
            label={"Tone(Optional)"}
            onChange={(e) => setTone(e.target.value)}>
            <MenuItem value="">None</MenuItem>
            <MenuItem value="professional">Professional</MenuItem>
            <MenuItem value="casual">Casual</MenuItem>
            <MenuItem value="friendly">Friendly</MenuItem>
          </Select>

        </FormControl>

        <Button
          variant='contained'
          onClick={handleSubmit}
          disabled={!emailContent || loading}
          fullWidth>
          {loading ? <CircularProgress size={24} /> : "Generate Reply"}
        </Button>

      </Box>

      {error && (
        <Typography color='error' sx={{ mb: 2 }}>
          {error}
        </Typography>
      )}

      {generateReply && (
        <Box sx={{ mt: 3 }}>
          <Typography variant='h6' gutterBottom>
            Generated Reply:
          </Typography>

          <TextField
            fullWidth
            multiline
            rows={6}
            variant='outlined'
            value={generateReply || ''}
            InputProps={{ readOnly: true }} />
          {
            copied &&
            <Alert severity="success" sx={{ mt: 2 }}>
              Copied to clipboard!
            </Alert>
          }
          <Button
            variant='outlined'
            sx={{ mt: 2 }}
            onClick={handleCopy}>
            {copied ? "Copied" : "Copy to Clipboard"}
          </Button>
        </Box>

      )}
    </Container>
  )
}

export default App
