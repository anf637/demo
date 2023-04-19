package helloSpring.demo.repository;

import helloSpring.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MebmerRepository
{

    private  static Map<Long, Member> store = new HashMap<>();
    private  static long seq = 0;

    @Override
    public Member save(Member member) {
        member.setId(++seq);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().findAny().stream().
                filter(member->member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
