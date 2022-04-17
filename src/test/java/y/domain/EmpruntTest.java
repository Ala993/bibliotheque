package y.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import y.web.rest.TestUtil;

class EmpruntTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Emprunt.class);
        Emprunt emprunt1 = new Emprunt();
        emprunt1.setId(1L);
        Emprunt emprunt2 = new Emprunt();
        emprunt2.setId(emprunt1.getId());
        assertThat(emprunt1).isEqualTo(emprunt2);
        emprunt2.setId(2L);
        assertThat(emprunt1).isNotEqualTo(emprunt2);
        emprunt1.setId(null);
        assertThat(emprunt1).isNotEqualTo(emprunt2);
    }
}
