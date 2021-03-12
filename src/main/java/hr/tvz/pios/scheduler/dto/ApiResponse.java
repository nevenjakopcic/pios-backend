package hr.tvz.pios.scheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

    private Object data;
    private String error;

    public ApiResponse(Object data) {
        this.data = data;
    }

    public ApiResponse(String error) {
        this.error = error;
    }
}
