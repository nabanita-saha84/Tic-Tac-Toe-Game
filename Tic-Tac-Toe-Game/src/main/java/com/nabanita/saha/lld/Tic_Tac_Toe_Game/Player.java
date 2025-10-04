package com.nabanita.saha.lld.Tic_Tac_Toe_Game;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {
    public String name;
    public Marker marker;
}
