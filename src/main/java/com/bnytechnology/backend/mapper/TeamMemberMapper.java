package com.bnytechnology.backend.mapper;

import com.bnytechnology.backend.dto.request.TeamMemberRequest;
import com.bnytechnology.backend.dto.response.TeamMemberResponse;
import com.bnytechnology.backend.entity.TeamMember;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface TeamMemberMapper {
    TeamMemberResponse toResponse(TeamMember entity);
    TeamMember toEntity(TeamMemberRequest request);
}
