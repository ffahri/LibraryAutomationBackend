package com.webischia.LibraryAutomationBackend.Domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    Items item;
    int[] authorIDs;
    int[] subjectIDs;

}
