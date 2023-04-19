package helloSpring.demo.repository;

import helloSpring.demo.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MebmerRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
