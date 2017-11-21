package net.thadir.failure.model;

import javax.xml.bind.annotation.XmlRootElement;

@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.ToString
@XmlRootElement
public class JsonQoutes {
  private String quote;
  private String author;
}
