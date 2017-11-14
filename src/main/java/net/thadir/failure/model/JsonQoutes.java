package net.thadir.failure.model;

import javax.xml.bind.annotation.XmlRootElement;

@lombok.Getter
@lombok.Setter
@lombok.RequiredArgsConstructor
@lombok.EqualsAndHashCode(of = { "quote","author" })
@lombok.ToString
@XmlRootElement
public class JsonQoutes {
  private final String quote;
  private       String author;
}
