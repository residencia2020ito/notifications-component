package com.notification.springboot.sending.app.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmail {


   private String idPlantilla;
   private String para;
   private String asunto;
   private Map<String, Object> map;
   

	
}
