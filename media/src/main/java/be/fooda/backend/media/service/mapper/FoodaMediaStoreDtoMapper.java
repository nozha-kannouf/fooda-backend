package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaStoreDto;

public class FoodaMediaStoreDtoMapper implements FoodaDtoMapper<FoodaMediaStoreDto, FoodaMediaStoreReq, FoodaMediaStoreRes> {
    @Override
    public FoodaMediaStoreDto requestToDto(FoodaMediaStoreReq foodaMediaStoreReq) {
        return null;
    }

    @Override
    public FoodaMediaStoreDto responseToDto(FoodaMediaStoreRes foodaMediaStoreRes) {
        return null;
    }

    @Override
    public FoodaMediaStoreReq dtoToRequest(FoodaMediaStoreDto foodaMediaStoreDto) {
        return null;
    }

    @Override
    public FoodaMediaStoreRes dtoToResponse(FoodaMediaStoreDto foodaMediaStoreDto) {
        return null;
    }
}
