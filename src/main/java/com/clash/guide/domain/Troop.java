package com.clash.guide.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Troop {
    @Id
    @Builder.Default
    private String _id = ObjectId.get().toHexString();
    private String name;
    private String description;
    private String image;
    @Builder.Default
    private String color = "0XFF00AFFF";
    @Builder.Default
    private Boolean isSuperTroop = false;
}
