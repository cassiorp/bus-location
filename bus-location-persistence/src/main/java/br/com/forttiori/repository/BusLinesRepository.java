package br.com.forttiori.repository;

import br.com.forttiori.entity.BusLine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusLinesRepository extends MongoRepository<BusLine, String> {
}
