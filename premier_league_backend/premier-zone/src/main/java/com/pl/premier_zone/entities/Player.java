package com.pl.premier_zone.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//entities represent the data model they map the tables
@Entity
// premier_league is a temp table
@Table(name = "premier_league") // the table name is not Player its "player_statistics" so the real table name
// give to be associated with

// @AllArgsConstructor
// @Getter
// @Setter
public class Player {
    @Id // this specifies the primary key also the id
    @Column(name = "name", unique = true) // and helps locate
    private String name;

    private String nation;

    private String pos;

    private Integer age;

    private Integer mp;

    private Integer starts;

    private Double min;

    private Double gls;

    private Double ast;

    private Double pk;

    private Double crdy;

    private Double crdr;

    private Double xg;

    private Double xag;

    private String team;

    public Player() {
        // Hibernate needs an empty constructor to create instances dynamically we can
        // use @NoArgsConstructor
        // also use
    }

    // instead of manually making this contructor @AllArgsConstructor could make it
    // automatically
    public Player(
            String name,
            String nation,
            String pos,
            Integer age,
            Integer mp,
            Integer starts,
            Double min,
            Double gls,
            Double ast,
            Double pk,
            Double crdy,
            Double crdr,
            Double xg,
            Double xag,
            String team) {
    }

    // instead of writing the code bellow we could have used @Getter and @Setter
    // whice will automaticaly do it
    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public double getMin() {
        if (min == null) {
            return 0;
        }
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getGls() {
        if (gls == null) {
            return 0;
        }
        return gls;
    }

    public void setGls(double gls) {
        this.gls = gls;
    }

    public double getAst() {
        if (ast == null) {
            return 0;
        }
        return ast;
    }

    public void setAst(double ast) {
        this.ast = ast;
    }

    public double getPk() {
        if (pk == null) {
            return 0;
        }
        return pk;
    }

    public void setPk(double pk) {
        this.pk = pk;
    }

    public double getCrdy() {
        if (crdy == null) {
            return 0;
        }
        return crdy;
    }

    public void setCrdy(double crdy) {
        this.crdy = crdy;
    }

    public double getCrdr() {
        if (crdr == null) {
            return 0;
        }
        return crdr;
    }

    public void setCrdr(double crdr) {
        this.crdr = crdr;
    }

    public double getXg() {
        if (xg == null) {
            return 0;
        }
        return xg;
    }

    public void setXg(double xg) {
        this.xg = xg;
    }

    public double getXag() {
        if (xag == null) {
            return 0;
        }
        return xag;
    }

    public void setXag(double xag) {
        this.xag = xag;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
