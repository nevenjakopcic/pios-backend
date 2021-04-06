package hr.tvz.pios.scheduler.mapper;

import hr.tvz.pios.scheduler.dto.response.MembershipDto;
import hr.tvz.pios.scheduler.model.Membership;

public class MembershipDtoMapper {

    public static MembershipDto map(Membership source) {
        return MembershipDto.builder()
            .id(source.getId())
            .purchasedAt(source.getPurchasedAt())
            .amount(source.getAmount())
            .purchaseType(source.getPurchaseType().ordinal())
            .user(UserDtoMapper.map(source.getUser()))
            .duration(source.getDuration().ordinal()).build();
    }

    private MembershipDtoMapper() {}
}
