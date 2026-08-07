package com.bnytechnology.backend.controller;

import com.bnytechnology.backend.dto.response.TeamMemberResponse;
import com.bnytechnology.backend.service.TeamMemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
public class PublicTeamMemberController {

    private final TeamMemberService service;

    public PublicTeamMemberController(TeamMemberService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TeamMemberResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamMemberResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
