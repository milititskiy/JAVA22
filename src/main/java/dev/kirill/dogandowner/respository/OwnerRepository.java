package dev.kirill.dogandowner.respository;

import dev.kirill.dogandowner.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Long, Owner> {
}
