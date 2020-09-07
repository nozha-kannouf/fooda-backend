package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaAppReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaAppRes;

public class FoodaMediaAppHttpMapper implements FoodaHttpMapper<FoodaMediaAppReq, FoodaMediaAppRes> {
    @Override
    public FoodaMediaAppReq responseToRequest(FoodaMediaAppRes foodaMediaAppRes) {
        return null;
    }

    @Override
    public FoodaMediaAppRes requestToResponse(FoodaMediaAppReq appReq) {
        return null;
    }
}
