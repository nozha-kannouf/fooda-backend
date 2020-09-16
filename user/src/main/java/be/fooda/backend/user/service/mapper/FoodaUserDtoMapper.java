package be.fooda.backend.user.service.mapper;

import be.fooda.backend.commons.model.template.user.request.FoodaUserReq;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRes;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRoleRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.user.model.dto.FoodaUserDto;
import be.fooda.backend.user.model.dto.FoodaUserRoleDto;

import java.util.Set;
import java.util.stream.Collectors;

public class FoodaUserDtoMapper implements FoodaDtoMapper<FoodaUserDto, FoodaUserReq, FoodaUserRes> {
    @Override
    public FoodaUserDto requestToDto(FoodaUserReq req) {

        return FoodaUserDto.builder()
                .login(req.getLogin())
                .password(req.getPassword())
                .build();
    }

    @Override
    public FoodaUserDto responseToDto(FoodaUserRes res) {

        return FoodaUserDto.builder()
                .login(res.getLogin())
                .userId(res.getUserId())
                .roles(resRoles(res))
                .build();
    }

    private Set<FoodaUserRoleDto> resRoles(FoodaUserRes res) {
        return res.getRoles().stream().map(role -> FoodaUserRoleDto.builder()
                .name(role.getTitle())
                .build()
        )
                .collect(Collectors.toSet());
    }

    @Override
    public FoodaUserReq dtoToRequest(FoodaUserDto dto) {

        return FoodaUserReq.builder()
                .password(dto.getPassword())
                .login(dto.getLogin())
                .build();
    }

    @Override
    public FoodaUserRes dtoToResponse(FoodaUserDto dto) {

        return FoodaUserRes.builder()
                .userId(dto.getUserId())
                .login(dto.getLogin())
                .roles(dtoRoles(dto))
                .build();
    }

    private Set<FoodaUserRoleRes> dtoRoles(FoodaUserDto dto) {
        return dto.getRoles()
                .stream()
                .map(role -> FoodaUserRoleRes.builder()
                        .title(role.getName())
                        .hasAccessToDella(role.getHasAccesstoDella())
                        .hasAccessToFooda(role.getHasAccessToFooda())
                        .hasAccessToResta(role.getHasAccesstoResta())
                        .build()
        )
                .collect(Collectors.toSet());
    }
}
