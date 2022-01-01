package com.medeil.repository;

import org.springframework.stereotype.Repository;
import com.medeil.domain.Usersession;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UsersessionRepository  extends JpaRepository<Usersession,Long>{

}
