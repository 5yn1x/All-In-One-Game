package com.aiog.allinonegame.view;

import com.aiog.allinonegame.model.Player;

import java.util.Map;

public interface PlayersStateView {
    void setCurrentPlayer(Player player);

    void setPlayerOccupyingBoxesCount(Map<Player, Integer> player_occupyingBoxesCount_map);

    void setWinner(Player winner);
}
