package org.example.yiduiyi;

import org.example.yiduiyi.Person;

public class Card {
    private Integer id;//主键id
    private String card;//身份证号码

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", card='" + card + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
