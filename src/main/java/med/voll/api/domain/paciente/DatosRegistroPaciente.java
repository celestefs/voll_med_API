package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroPaciente(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String documento,
        @NotBlank
        String telefono,
        @NotNull
        @Valid
        DatosDireccion direccion) {
}

// para personalizar los mensajes de validacion:
// @NotBlank(message = "Nombre es obligatorio")
// sino crear archivo ValidationMessages.properties en src/main/resources:
// nombre.obligatorio=El nombre es obligatorio
// email.obligatorio=Correo electrónico requerido
// email.invalido=El formato del correo electrónico no es válido
// phone.obligatorio=Teléfono requerido
// documento.obligatorio=CRM es obligatorio
// documento.invalido=El formato CRM no es válido
// especialidad.obligatorio=La especialidad es obligatoria
// address.obligatorio=Los datos de dirección son obligatorios
// y en las anotaciones poner:  @NotBlank(message = "{nombre.obligatorio}")
// @Pattern(regexp = "\\d{4,6}", message = "{documento.invalido}") @Email(message = "{email.invalido}")
