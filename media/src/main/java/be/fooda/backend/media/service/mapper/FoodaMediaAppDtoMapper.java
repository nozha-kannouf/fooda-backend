package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaAppDto;

public class FoodaMediaAppDtoMapper implements FoodaDtoMapper<FoodaMediaAppDto, FoodaMediaAppReq, FoodaMediaAppRes> {
    @Override
    public FoodaMediaAppDto requestToDto(FoodaMediaAppReq appReq) {
        return null;
    }

    @Override
    public FoodaMediaAppDto responseToDto(FoodaMediaAppRes foodaMediaAppRes) {
        return null;
    }

    @Override
    public FoodaMediaAppReq dtoToRequest(FoodaMediaAppDto foodaMediaAppDto) {
        return null;
    }

    @Override
    public FoodaMediaAppRes dtoToResponse(FoodaMediaAppDto foodaMediaAppDto) {
        return null;
    }
}
