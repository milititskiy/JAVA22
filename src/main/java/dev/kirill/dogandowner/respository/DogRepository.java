package dev.kirill.dogandowner.respository;

import dev.kirill.dogandowner.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Long, Dog> {
}
