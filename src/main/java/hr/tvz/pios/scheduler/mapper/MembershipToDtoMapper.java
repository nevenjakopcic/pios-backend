package hr.tvz.pios.scheduler.mapper;

import hr.tvz.pios.scheduler.dto.response.MembershipDto;
import hr.tvz.pios.scheduler.model.Membership;

public class MembershipToDtoMapper {

    public static MembershipDto map(Membership source) {
        return MembershipDto.builder()
            .id(source.getId())
            .purchasedAt(source.getPurchasedAt())
            .amount(source.getAmount())
            .purchaseType(source.getPurchaseType().ordinal())
            .user(UserToDtoMapper.map(source.getUser()))
            .duration(source.getDuration().ordinal()).build();
    }

    private MembershipToDtoMapper() {}
}
