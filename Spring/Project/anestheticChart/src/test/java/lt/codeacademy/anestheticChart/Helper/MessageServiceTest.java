package lt.codeacademy.anestheticChart.Helper;

import lt.codeacademy.anestheticChart.mvc.chart.helper.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {
  private final String MESSAGE_KEY = "Dummy.key";
  private final String MESSAGE_VALUE = "dummyValue";

  @Mock private MessageSource messageSource;

  @InjectMocks private MessageService messageService;

  @Test
  void testGetMessage_WhenKeyIsNull_ThrowException() {
    // given
    final String key = null;
    Mockito.doThrow(NoSuchMessageException.class)
        .when(messageSource)
        .getMessage(eq(key), any(), any(Locale.class));
    // when
    String message = messageService.getMessage(key);
    // then
    assertNotNull(message);
    assertEquals("", message);
  }

  @Test
  void testGetMessage_WhenKeyNotExist() {
    // given
    final String key = MESSAGE_KEY;
    Mockito.doThrow(NoSuchMessageException.class)
        .when(messageSource)
        .getMessage(eq(key), any(), any(Locale.class));
    // when
    String message = messageService.getMessage(key);
    // then
    assertNotNull(message);
    assertEquals("?" + key + "?", message);
  }

  @Test
  void testGetMessage_WhenKeyExists() {
    // given
    final String key = MESSAGE_KEY;
    Mockito.when(messageSource.getMessage(eq(key), any(), any(Locale.class)))
        .thenReturn(MESSAGE_VALUE);
    // when
    String message = messageService.getMessage(key);
    // then
    assertNotNull(message);
    assertEquals(MESSAGE_VALUE, message);
  }
}
