package Project.bookity.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookEntity {
@Id
@Column
private String isbn;
@Column
private String bookname;
@Column
private String category;
@Column
private String imageUrl;

}
