package com.ejemplo.Eje.models;

import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "useless")
@NoArgsConstructor
public class useless {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Nullable
    private String howUseless, whyUseless;

    private boolean yes;

    private float usefulPercentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public useless(@Nullable String howUseless, @Nullable String whyUseless, boolean yes, float usefulPercentage) {
        this.howUseless = howUseless;
        this.whyUseless = whyUseless;
        this.yes = yes;
        this.usefulPercentage = usefulPercentage;
    }

    @Nullable
    public String getHowUseless() {
        return howUseless;
    }

    public void setHowUseless(@Nullable String howUseless) {
        this.howUseless = howUseless;
    }

    @Nullable
    public String getWhyUseless() {
        return whyUseless;
    }

    public void setWhyUseless(@Nullable String whyUseless) {
        this.whyUseless = whyUseless;
    }

    public boolean isYes() {
        return yes;
    }

    public void setYes(boolean yes) {
        this.yes = yes;
    }

    public float getUsefulPercentage() {
        return usefulPercentage;
    }

    public void setUsefulPercentage(float usefulPercentage) {
        this.usefulPercentage = usefulPercentage;
    }

    @Override
    public String toString() {
        return "Useless{" +
                "id=" + id +
                ", howUseless='" + howUseless + '\'' +
                ", whyUseless='" + whyUseless + '\'' +
                ", yes=" + yes +
                ", usefulPercentage=" + usefulPercentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        useless useless = (com.ejemplo.Eje.models.useless) o;
        return yes == useless.yes && Float.compare(useless.usefulPercentage, usefulPercentage) == 0 && id.equals(useless.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yes, usefulPercentage);
    }
}