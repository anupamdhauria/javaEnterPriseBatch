package in.ineuron.service;

import java.util.Optional;

import in.ineuron.bo.MarraigeSeeker;

public interface IMarraigeServiceMgmt {

	public String registerMarraigeSeeker(MarraigeSeeker seeker);
	public Optional<MarraigeSeeker> searchById(Long id);
}
