package com.epsi.guez.tp4nosql.service;

import com.epsi.guez.tp4nosql.model.Note;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

    private RedisTemplate<String, Note> redisTemplate;

    private HashOperations hashOperations;

    public NoteRepositoryImpl(RedisTemplate<String, Note> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Note note) {
        hashOperations.put("NOTE", note.getId(), note);
    }

    @Override
    public Map<String, Note> findAll() {
        return hashOperations.entries("NOTE");
    }

    @Override
    public Note findById(String id) {
        return (Note) hashOperations.get("NOTE", id);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("NOTE", id);
    }
}
