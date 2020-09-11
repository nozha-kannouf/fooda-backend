package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppSourceReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppSourceRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaAppDto;
import be.fooda.backend.media.model.dto.FoodaMediaTypeDto;

public class FoodaMediaAppDtoMapper implements FoodaDtoMapper<FoodaMediaAppDto, FoodaMediaAppReq, FoodaMediaAppRes> {
    @Override
    public FoodaMediaAppDto requestToDto(FoodaMediaAppReq appReq) {
        return FoodaMediaAppDto.builder()
                .appSourceId(appReq.getAppSource().getAppSourceId())
                .url(appReq.getUrl())
                .type(mediaTypeDto(appReq))
                .build();
    }

    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaAppReq appReq) {
        return FoodaMediaTypeDto.builder()
                .typeId(appReq.getType().getTypeId())
                .title(appReq.getType().getTitle())
                .extension(appReq.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaAppDto responseToDto(FoodaMediaAppRes appRes) {
        return FoodaMediaAppDto.builder()
                .appSourceId(appRes.getAppSource().getAppSourceId())
                .url(appRes.getUrl())
                .type(mediaTypeDto(appRes))
                .build();

    }
    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaAppRes appRes) {
        return FoodaMediaTypeDto.builder()
                .typeId(appRes.getType().getTypeId())
                .title(appRes.getType().getTitle())
                .extension(appRes.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaAppReq dtoToRequest(FoodaMediaAppDto appDto) {
        return FoodaMediaAppReq.builder()
                .url(appDto.getUrl())
                .appSource(mediaAppSourceReq(appDto))
                .type(mediaTypeReq(appDto))
                .build();
    }

    private FoodaMediaTypeReq mediaTypeReq(FoodaMediaAppDto appDto) {
        return FoodaMediaTypeReq.builder()
                .typeId(appDto.getType().getTypeId())
                .title(appDto.getType().getTitle())
                .extension(appDto.getType().getExtension())
                .build();
    }

    private FoodaMediaAppSourceReq mediaAppSourceReq(FoodaMediaAppDto appDto) {
        return FoodaMediaAppSourceReq.builder()
                .appSourceId(appDto.getAppSourceId())
                .url(appDto.getUrl())
                .mustBeCached(false)
                .title(appDto.getType().getTitle())
                .build();
    }

    @Override
    public FoodaMediaAppRes dtoToResponse(FoodaMediaAppDto appDto) {
         FoodaMediaAppRes mediaAppRes=new FoodaMediaAppRes();
        mediaAppRes.setUrl(appDto.getUrl());
        mediaAppRes.setAppSource(mediaAppSourceRes(appDto));
        mediaAppRes.setType(mediaTypeRes(appDto));
        return mediaAppRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaAppDto appDto) {
        FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setTypeId(appDto.getType().getTypeId());
        mediaTypeRes.setTitle(appDto.getType().getTitle());
        mediaTypeRes.setExtension(appDto.getType().getExtension());
        return mediaTypeRes;
    }

    private FoodaMediaAppSourceRes mediaAppSourceRes(FoodaMediaAppDto appDto) {
        FoodaMediaAppSourceRes mediaAppSourceRes=new FoodaMediaAppSourceRes();
        mediaAppSourceRes.setAppSourceId(appDto.getAppSourceId());
        mediaAppSourceRes.setMustBeCached(false);
        mediaAppSourceRes.setUrl(appDto.getUrl());
        mediaAppSourceRes.setTitle(appDto.getType().getTitle());

        return mediaAppSourceRes;
    }
}
