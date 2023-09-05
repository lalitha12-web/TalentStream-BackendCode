package com.bitlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitlabs.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
