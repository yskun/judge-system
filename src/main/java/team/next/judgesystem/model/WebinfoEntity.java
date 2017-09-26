package team.next.judgesystem.model;

import javax.persistence.*;

/**
 * Created by YsKun on 2017/6/19.
 * NEXT TEAM copyright
 * 黄日晟
 */
@Entity
@Table(name = "Webinfo", schema = "dbo", catalog = "shamomo")
public class WebinfoEntity {
    private String url;
    private int webstate;
    private WebStateEntity webStateByWebstate;

    @Id
    @Column(name = "Url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebinfoEntity that = (WebinfoEntity) o;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Basic
    @Column(name = "Webstate")
    public int getWebstate() {
        return webstate;
    }

    public void setWebstate(int webstate) {
        this.webstate = webstate;
    }

    @ManyToOne
    @JoinColumn(name = "Webstate", referencedColumnName = "Id", nullable = false,insertable = false,updatable = false)
    public WebStateEntity getWebStateByWebstate() {
        return webStateByWebstate;
    }

    public void setWebStateByWebstate(WebStateEntity webStateByWebstate) {
        this.webStateByWebstate = webStateByWebstate;
    }
}
