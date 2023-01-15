package com.wizeline.onsite.events;

import com.wizeline.onsite.models.UsuarioModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioCreatedEvent extends Event<UsuarioModel> {

}
