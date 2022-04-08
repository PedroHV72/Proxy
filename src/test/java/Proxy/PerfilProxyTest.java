package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.fail;

public class PerfilProxyTest {

    @BeforeEach
    void setUp() {
        BD.addPerfil(new Perfil("Maria", "solteira", "Descrição do perfil", 25, 41));
        BD.addPerfil(new Perfil("João", "casado", "Descrição do perfil", 38, 14));
    }

    @Test
    void deveRetonarExcecaoPerfilPrivadoUsuarioNaoAutorizadoObterFotos() {
        try {
            Usuario usuario = new Usuario("Joana", false);
            PerfilProxy perfilProxy = new PerfilProxy(22);
            perfilProxy.obterFotos(usuario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Perfil Privado", e.getMessage());
        }
    }
}
