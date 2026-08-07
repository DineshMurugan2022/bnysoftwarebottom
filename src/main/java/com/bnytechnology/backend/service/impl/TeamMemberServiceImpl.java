package com.bnytechnology.backend.service.impl;

import com.bnytechnology.backend.dto.request.TeamMemberRequest;
import com.bnytechnology.backend.dto.response.TeamMemberResponse;
import com.bnytechnology.backend.entity.TeamMember;
import com.bnytechnology.backend.mapper.TeamMemberMapper;
import com.bnytechnology.backend.repository.TeamMemberRepository;
import com.bnytechnology.backend.service.TeamMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@SuppressWarnings("null")
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository repository;
    private final TeamMemberMapper mapper;

    public TeamMemberServiceImpl(TeamMemberRepository repository, TeamMemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TeamMemberResponse> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TeamMemberResponse findById(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Team member not found"));
    }

    @Override
    public TeamMemberResponse create(TeamMemberRequest request) {
        TeamMember entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public TeamMemberResponse update(Long id, TeamMemberRequest request) {
        TeamMember existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team member not found"));
        
        TeamMember updated = mapper.toEntity(request);
        updated.setId(id);
        if(existing.getCreatedAt() != null) updated.setCreatedAt(existing.getCreatedAt());
        if(existing.getCreatedBy() != null) updated.setCreatedBy(existing.getCreatedBy());
        return mapper.toResponse(repository.save(updated));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
