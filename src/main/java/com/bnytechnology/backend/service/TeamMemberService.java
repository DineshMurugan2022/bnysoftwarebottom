package com.bnytechnology.backend.service;

import com.bnytechnology.backend.dto.request.TeamMemberRequest;
import com.bnytechnology.backend.dto.response.TeamMemberResponse;
import java.util.List;

public interface TeamMemberService {
    List<TeamMemberResponse> findAll();
    TeamMemberResponse findById(Long id);
    TeamMemberResponse create(TeamMemberRequest request);
    TeamMemberResponse update(Long id, TeamMemberRequest request);
    void delete(Long id);
}
