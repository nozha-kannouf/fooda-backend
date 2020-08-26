package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.dto.FoodaMediaAppDto;
import be.fooda.backend.commons.model.template.media.dto.FoodaMediaTypeDto;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppSourceReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppSourceRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;

public class FoodaMediaAppMapper implements FoodaObjectMapper<FoodaMediaAppDto, FoodaMediaAppReq, FoodaMediaAppRes> {
    @Override
    public FoodaMediaAppReq dtoToRequest(FoodaMediaAppDto appDto) {
        return FoodaMediaAppReq.builder()
                .appSource(appSourceReq(appDto))
                //.appSourceMediaId(appDto)
                .type(typeReq(appDto))
                .url(appDto.getUrl())
                .build();
    }

    private FoodaMediaTypeReq typeReq(FoodaMediaAppDto appDto) {
        return FoodaMediaTypeReq.builder()
                .extension(appDto.getType().getExtension())
                .title(appDto.getType().getTitle())
                .typeId(appDto.getType().getTypeId())
                .build();
    }

    private FoodaMediaAppSourceReq appSourceReq(FoodaMediaAppDto appDto) {
        return FoodaMediaAppSourceReq.builder()
                .appSourceId(appDto.getAppSourceId())
                .mustBeCached(false)
                //.resolution(appDto.g)
                .title(appDto.getType().getTitle())
                .url(appDto.getUrl())
                .build();
    }

    @Override
    public FoodaMediaAppReq responseToRequest(FoodaMediaAppRes appRes) {
        return FoodaMediaAppReq.builder()
                .url(appRes.getUrl())
                .type(typeReq(appRes))
                .appSourceMediaId(appRes.getAppSourceMediaId())
                .appSource(appSourceReq(appRes))
                .build();
    }
    private FoodaMediaAppSourceReq appSourceReq(FoodaMediaAppRes appRes) {
        return FoodaMediaAppSourceReq.builder()
                .url(appRes.getUrl())
                .title(appRes.getType().getTitle())
                .resolution(appRes.getAppSource().getResolution())
                .mustBeCached(false)
                .appSourceId(appRes.getAppSource().getAppSourceId())
                .build();
    }
    private FoodaMediaTypeReq typeReq(FoodaMediaAppRes appRes) {
        return FoodaMediaTypeReq.builder()
                .extension(appRes.getType().getExtension())
                .title(appRes.getType().getTitle())
                .typeId(appRes.getType().getTypeId())
                .build();
    }
    @Override
    public FoodaMediaAppRes dtoToResponse(FoodaMediaAppDto appDto) {
        final FoodaMediaAppRes mediaAppRes=new FoodaMediaAppRes();
        mediaAppRes.setUrl(appDto.getUrl());
        //mediaAppRes.setAppSourceMediaId(appDto.);
        mediaAppRes.setAppSource(appSourceRes(appDto));
        mediaAppRes.setType(typeRes(appDto));

        return mediaAppRes;
    }

    private FoodaMediaTypeRes typeRes(FoodaMediaAppDto appDto) {
        FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setExtension(appDto.getType().getExtension());
        mediaTypeRes.setTypeId(appDto.getType().getTypeId());
        mediaTypeRes.setTitle(appDto.getType().getTitle());
        return mediaTypeRes;
    }

    private FoodaMediaAppSourceRes appSourceRes(FoodaMediaAppDto appDto) {
        FoodaMediaAppSourceRes mediaAppSourceRes=new FoodaMediaAppSourceRes();
        mediaAppSourceRes.setAppSourceId(appDto.getAppSourceId());
        mediaAppSourceRes.setMustBeCached(false);
        //mediaAppSourceRes.setResolution(appDto);
        mediaAppSourceRes.setTitle(appDto.getType().getTitle());
        mediaAppSourceRes.setUrl(appDto.getUrl());
        return mediaAppSourceRes;
    }

    @Override
    public FoodaMediaAppRes requestToResponse(FoodaMediaAppReq appReq) {
        FoodaMediaAppRes mediaAppRes=new FoodaMediaAppRes();
        mediaAppRes.setAppSourceMediaId(appReq.getAppSourceMediaId());
        mediaAppRes.setUrl(appReq.getUrl());
        mediaAppRes.setAppSource(appSourceRes(appReq));
        mediaAppRes.setType(typeRes(appReq));

        return  mediaAppRes;
    }
    private FoodaMediaTypeRes typeRes(FoodaMediaAppReq appReq) {
        FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setExtension(appReq.getType().getExtension());
        mediaTypeRes.setTypeId(appReq.getType().getTypeId());
        mediaTypeRes.setTitle(appReq.getType().getTitle());
        return mediaTypeRes;
    }
    private FoodaMediaAppSourceRes appSourceRes(FoodaMediaAppReq appReq) {
        FoodaMediaAppSourceRes mediaAppSourceRes=new FoodaMediaAppSourceRes();
        mediaAppSourceRes.setAppSourceId(appReq.getAppSource().getAppSourceId());
        mediaAppSourceRes.setMustBeCached(false);
        mediaAppSourceRes.setResolution(appReq.getAppSource().getResolution());
        mediaAppSourceRes.setTitle(appReq.getType().getTitle());
        mediaAppSourceRes.setUrl(appReq.getUrl());
        return mediaAppSourceRes;
    }
    @Override
    public FoodaMediaAppDto requestToDto(FoodaMediaAppReq appReq) {
        return FoodaMediaAppDto.builder()
                .appSourceId(appReq.getAppSource().getAppSourceId())
                //.storeMediaId(appReq.g)
                .type(typeDto(appReq))
                .url(appReq.getUrl())
                .build();
    }

    private FoodaMediaTypeDto typeDto(FoodaMediaAppReq appReq) {
        return FoodaMediaTypeDto.builder()
                .typeId(appReq.getType().getTypeId())
                .title(appReq.getType().getTitle())
                .extension(appReq.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaAppDto responseToDto(FoodaMediaAppRes appRes) {
        return FoodaMediaAppDto.builder()
                //.storeMediaId(appRes)
                .url(appRes.getUrl())
                .type(typeDto(appRes))
                .appSourceId(appRes.getAppSource().getAppSourceId())
                .build();
    }
    private FoodaMediaTypeDto typeDto(FoodaMediaAppRes appRes) {
        return FoodaMediaTypeDto.builder()
                .typeId(appRes.getType().getTypeId())
                .title(appRes.getType().getTitle())
                .extension(appRes.getType().getExtension())
                .build();
    }

}
