package com.bitlabs.service;

import org.springframework.stereotype.Service;

import com.bitlabs.entity.Profile;
import com.bitlabs.repo.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService{
	private ProfileRepository profileRepository;
	
	

	public ProfileServiceImpl(ProfileRepository profileRepository) {
		super();
		this.profileRepository = profileRepository;
	}



	@Override
	public Profile saveProfile(Profile profile) {
		// TODO Auto-generated method stub
		 return profileRepository.save(profile);
	}

}
