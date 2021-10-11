package by.epam.jwd.sak.avtobase.bean;

import lombok.Builder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder

public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private LocalDateTime commentDate;
    private Integer mark;
    private String message;

    public Comment() {
    }

    public Comment(Integer id, LocalDateTime commentDate, Integer mark, String message) {
        this.id = id;
        this.commentDate = commentDate;
        this.mark = mark;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Comment ");
        sb.append("id = ");
        sb.append(id);
        sb.append(", commentDate = ");
        sb.append(commentDate);
        sb.append(", mark = ");
        sb.append(mark);
        sb.append(", message = ");
        sb.append(message);
        return sb.toString();
    }
}
