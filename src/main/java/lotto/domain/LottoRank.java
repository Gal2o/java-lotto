package lotto.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_BONUS_PLACE(5, 30_000_000, true),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PACE(4, 50_000),
    FOURTH_PLACE(3, 5_000),
    NO_PLACE(0, 0);

    private final int matchCount;
    private final long amount;
    private final boolean matchBonus;

    LottoRank(int matchCount, long amount) {
        this(matchCount, amount, false);
    }

    LottoRank(int matchCount, long amount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.matchBonus = matchBonus;
    }

    public static LottoRank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchBonus == matchBonus)
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NO_PLACE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getAmount() {
        return amount;
    }
}
