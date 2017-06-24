package com.goldenimper.hxhgenerator.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pj {
    private String name;
    private List<Stat> stats;
    private List<Ability> abilities;
    private List<Ability> abilitiesDone;
    
    //constructores
    public Pj(String name, List<Stat> stats, List<Ability> abilities, List<Ability> abilitiesDone) {
        this.name = name;
        this.stats = stats;
        this.abilities = abilities;
        this.abilitiesDone = abilitiesDone;
    }
    public Pj(List<Stat> stats, List<Ability> abilities, List<Ability> abilitiesDone) {
        this.stats = stats;
        this.abilities = abilities;
        this.abilitiesDone = abilitiesDone;
    }
    public Pj() {
    }
    
    //get set
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Stat> getStats() {
        return stats;
    }
    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
    public void addStat(Stat stat) {
        this.stats.add(stat);
    }
    public List<Ability> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
    public void addAbility(Ability ability) {
        this.abilities.add(ability);
    }
    public List<Ability> getAbilitiesDone() {
        return abilitiesDone;
    }
    public void setAbilitiesDone(List<Ability> abilities) {
        this.abilitiesDone = abilities;
    }
    public void addAbilityDone(Ability ability) {
        this.abilitiesDone.add(ability);
        
        Collections.sort(this.abilitiesDone, new Comparator<Ability>() {
            @Override
            public int compare(Ability a1, Ability a2) {
                return a1.getNombre().compareTo(a2.getNombre());
            }
        });
    }
}