package vip.example.buxarkaanand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vip.example.buxarkaanand.model.Suggestion;

public interface SuggestRepo extends JpaRepository<Suggestion , Long> {

}
