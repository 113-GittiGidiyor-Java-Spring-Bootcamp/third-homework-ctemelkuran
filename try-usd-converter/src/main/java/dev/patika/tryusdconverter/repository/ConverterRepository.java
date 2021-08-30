package dev.patika.tryusdconverter.repository;

import dev.patika.tryusdconverter.entity.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRepository extends CrudRepository<Converter, Integer> {
}
