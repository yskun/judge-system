package team.next.judgesystem.model;

import javax.persistence.*;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Entity
@Table(name = "WebState", schema = "dbo", catalog = "shamomo")
public class WebStateEntity {
    private int id;
    private String stateDescription;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "StateDescription")
    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebStateEntity that = (WebStateEntity) o;

        if (id != that.id) return false;
        if (stateDescription != null ? !stateDescription.equals(that.stateDescription) : that.stateDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stateDescription != null ? stateDescription.hashCode() : 0);
        return result;
    }
}
