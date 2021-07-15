// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageProtocol.proto

package com.micolx.connector.protobuf;

/**
 * Protobuf enum {@code AckType}
 */
public enum AckType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SENT = 0;</code>
   */
  SENT(0),
  /**
   * <code>RECEIVED = 1;</code>
   */
  RECEIVED(1),
  /**
   * <code>READ = 2;</code>
   */
  READ(2),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SENT = 0;</code>
   */
  public static final int SENT_VALUE = 0;
  /**
   * <code>RECEIVED = 1;</code>
   */
  public static final int RECEIVED_VALUE = 1;
  /**
   * <code>READ = 2;</code>
   */
  public static final int READ_VALUE = 2;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static AckType valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static AckType forNumber(int value) {
    switch (value) {
      case 0: return SENT;
      case 1: return RECEIVED;
      case 2: return READ;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AckType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AckType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AckType>() {
          public AckType findValueByNumber(int number) {
            return AckType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.micolx.connector.protobuf.MessageProtocol.getDescriptor().getEnumTypes().get(0);
  }

  private static final AckType[] VALUES = values();

  public static AckType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private AckType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:AckType)
}
