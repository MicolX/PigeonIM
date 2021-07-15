// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageProtocol.proto

package com.micolx.connector.protobuf;

/**
 * Protobuf type {@code ChatMessage}
 */
public final class ChatMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ChatMessage)
    ChatMessageOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ChatMessage.newBuilder() to construct.
  private ChatMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatMessage() {
    msgID_ = "";
    senderID_ = "";
    recipientID_ = "";
    content_ = "";
    time_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ChatMessage();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChatMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            msgID_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            senderID_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            recipientID_ = s;
            break;
          }
          case 32: {

            sequenceID_ = input.readInt32();
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            content_ = s;
            break;
          }
          case 50: {
            java.lang.String s = input.readStringRequireUtf8();

            time_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.micolx.connector.protobuf.MessageProtocol.internal_static_ChatMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.micolx.connector.protobuf.MessageProtocol.internal_static_ChatMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.micolx.connector.protobuf.ChatMessage.class, com.micolx.connector.protobuf.ChatMessage.Builder.class);
  }

  public static final int MSGID_FIELD_NUMBER = 1;
  private volatile java.lang.Object msgID_;
  /**
   * <code>string msgID = 1;</code>
   * @return The msgID.
   */
  @java.lang.Override
  public java.lang.String getMsgID() {
    java.lang.Object ref = msgID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      msgID_ = s;
      return s;
    }
  }
  /**
   * <code>string msgID = 1;</code>
   * @return The bytes for msgID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMsgIDBytes() {
    java.lang.Object ref = msgID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      msgID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SENDERID_FIELD_NUMBER = 2;
  private volatile java.lang.Object senderID_;
  /**
   * <code>string senderID = 2;</code>
   * @return The senderID.
   */
  @java.lang.Override
  public java.lang.String getSenderID() {
    java.lang.Object ref = senderID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      senderID_ = s;
      return s;
    }
  }
  /**
   * <code>string senderID = 2;</code>
   * @return The bytes for senderID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSenderIDBytes() {
    java.lang.Object ref = senderID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      senderID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RECIPIENTID_FIELD_NUMBER = 3;
  private volatile java.lang.Object recipientID_;
  /**
   * <code>string recipientID = 3;</code>
   * @return The recipientID.
   */
  @java.lang.Override
  public java.lang.String getRecipientID() {
    java.lang.Object ref = recipientID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      recipientID_ = s;
      return s;
    }
  }
  /**
   * <code>string recipientID = 3;</code>
   * @return The bytes for recipientID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRecipientIDBytes() {
    java.lang.Object ref = recipientID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      recipientID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SEQUENCEID_FIELD_NUMBER = 4;
  private int sequenceID_;
  /**
   * <code>int32 sequenceID = 4;</code>
   * @return The sequenceID.
   */
  @java.lang.Override
  public int getSequenceID() {
    return sequenceID_;
  }

  public static final int CONTENT_FIELD_NUMBER = 5;
  private volatile java.lang.Object content_;
  /**
   * <code>string content = 5;</code>
   * @return The content.
   */
  @java.lang.Override
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      content_ = s;
      return s;
    }
  }
  /**
   * <code>string content = 5;</code>
   * @return The bytes for content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TIME_FIELD_NUMBER = 6;
  private volatile java.lang.Object time_;
  /**
   * <code>string time = 6;</code>
   * @return The time.
   */
  @java.lang.Override
  public java.lang.String getTime() {
    java.lang.Object ref = time_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      time_ = s;
      return s;
    }
  }
  /**
   * <code>string time = 6;</code>
   * @return The bytes for time.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getTimeBytes() {
    java.lang.Object ref = time_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      time_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getMsgIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, msgID_);
    }
    if (!getSenderIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, senderID_);
    }
    if (!getRecipientIDBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, recipientID_);
    }
    if (sequenceID_ != 0) {
      output.writeInt32(4, sequenceID_);
    }
    if (!getContentBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, content_);
    }
    if (!getTimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, time_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getMsgIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, msgID_);
    }
    if (!getSenderIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, senderID_);
    }
    if (!getRecipientIDBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, recipientID_);
    }
    if (sequenceID_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, sequenceID_);
    }
    if (!getContentBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, content_);
    }
    if (!getTimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, time_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.micolx.connector.protobuf.ChatMessage)) {
      return super.equals(obj);
    }
    com.micolx.connector.protobuf.ChatMessage other = (com.micolx.connector.protobuf.ChatMessage) obj;

    if (!getMsgID()
        .equals(other.getMsgID())) return false;
    if (!getSenderID()
        .equals(other.getSenderID())) return false;
    if (!getRecipientID()
        .equals(other.getRecipientID())) return false;
    if (getSequenceID()
        != other.getSequenceID()) return false;
    if (!getContent()
        .equals(other.getContent())) return false;
    if (!getTime()
        .equals(other.getTime())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + MSGID_FIELD_NUMBER;
    hash = (53 * hash) + getMsgID().hashCode();
    hash = (37 * hash) + SENDERID_FIELD_NUMBER;
    hash = (53 * hash) + getSenderID().hashCode();
    hash = (37 * hash) + RECIPIENTID_FIELD_NUMBER;
    hash = (53 * hash) + getRecipientID().hashCode();
    hash = (37 * hash) + SEQUENCEID_FIELD_NUMBER;
    hash = (53 * hash) + getSequenceID();
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    hash = (37 * hash) + TIME_FIELD_NUMBER;
    hash = (53 * hash) + getTime().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.micolx.connector.protobuf.ChatMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.micolx.connector.protobuf.ChatMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ChatMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ChatMessage)
      com.micolx.connector.protobuf.ChatMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.micolx.connector.protobuf.MessageProtocol.internal_static_ChatMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.micolx.connector.protobuf.MessageProtocol.internal_static_ChatMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.micolx.connector.protobuf.ChatMessage.class, com.micolx.connector.protobuf.ChatMessage.Builder.class);
    }

    // Construct using com.micolx.connector.protobuf.ChatMessage.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      msgID_ = "";

      senderID_ = "";

      recipientID_ = "";

      sequenceID_ = 0;

      content_ = "";

      time_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.micolx.connector.protobuf.MessageProtocol.internal_static_ChatMessage_descriptor;
    }

    @java.lang.Override
    public com.micolx.connector.protobuf.ChatMessage getDefaultInstanceForType() {
      return com.micolx.connector.protobuf.ChatMessage.getDefaultInstance();
    }

    @java.lang.Override
    public com.micolx.connector.protobuf.ChatMessage build() {
      com.micolx.connector.protobuf.ChatMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.micolx.connector.protobuf.ChatMessage buildPartial() {
      com.micolx.connector.protobuf.ChatMessage result = new com.micolx.connector.protobuf.ChatMessage(this);
      result.msgID_ = msgID_;
      result.senderID_ = senderID_;
      result.recipientID_ = recipientID_;
      result.sequenceID_ = sequenceID_;
      result.content_ = content_;
      result.time_ = time_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.micolx.connector.protobuf.ChatMessage) {
        return mergeFrom((com.micolx.connector.protobuf.ChatMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.micolx.connector.protobuf.ChatMessage other) {
      if (other == com.micolx.connector.protobuf.ChatMessage.getDefaultInstance()) return this;
      if (!other.getMsgID().isEmpty()) {
        msgID_ = other.msgID_;
        onChanged();
      }
      if (!other.getSenderID().isEmpty()) {
        senderID_ = other.senderID_;
        onChanged();
      }
      if (!other.getRecipientID().isEmpty()) {
        recipientID_ = other.recipientID_;
        onChanged();
      }
      if (other.getSequenceID() != 0) {
        setSequenceID(other.getSequenceID());
      }
      if (!other.getContent().isEmpty()) {
        content_ = other.content_;
        onChanged();
      }
      if (!other.getTime().isEmpty()) {
        time_ = other.time_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.micolx.connector.protobuf.ChatMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.micolx.connector.protobuf.ChatMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object msgID_ = "";
    /**
     * <code>string msgID = 1;</code>
     * @return The msgID.
     */
    public java.lang.String getMsgID() {
      java.lang.Object ref = msgID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        msgID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string msgID = 1;</code>
     * @return The bytes for msgID.
     */
    public com.google.protobuf.ByteString
        getMsgIDBytes() {
      java.lang.Object ref = msgID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        msgID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string msgID = 1;</code>
     * @param value The msgID to set.
     * @return This builder for chaining.
     */
    public Builder setMsgID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      msgID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string msgID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMsgID() {
      
      msgID_ = getDefaultInstance().getMsgID();
      onChanged();
      return this;
    }
    /**
     * <code>string msgID = 1;</code>
     * @param value The bytes for msgID to set.
     * @return This builder for chaining.
     */
    public Builder setMsgIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      msgID_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object senderID_ = "";
    /**
     * <code>string senderID = 2;</code>
     * @return The senderID.
     */
    public java.lang.String getSenderID() {
      java.lang.Object ref = senderID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        senderID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string senderID = 2;</code>
     * @return The bytes for senderID.
     */
    public com.google.protobuf.ByteString
        getSenderIDBytes() {
      java.lang.Object ref = senderID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        senderID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string senderID = 2;</code>
     * @param value The senderID to set.
     * @return This builder for chaining.
     */
    public Builder setSenderID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      senderID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string senderID = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSenderID() {
      
      senderID_ = getDefaultInstance().getSenderID();
      onChanged();
      return this;
    }
    /**
     * <code>string senderID = 2;</code>
     * @param value The bytes for senderID to set.
     * @return This builder for chaining.
     */
    public Builder setSenderIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      senderID_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object recipientID_ = "";
    /**
     * <code>string recipientID = 3;</code>
     * @return The recipientID.
     */
    public java.lang.String getRecipientID() {
      java.lang.Object ref = recipientID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        recipientID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string recipientID = 3;</code>
     * @return The bytes for recipientID.
     */
    public com.google.protobuf.ByteString
        getRecipientIDBytes() {
      java.lang.Object ref = recipientID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        recipientID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string recipientID = 3;</code>
     * @param value The recipientID to set.
     * @return This builder for chaining.
     */
    public Builder setRecipientID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      recipientID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string recipientID = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearRecipientID() {
      
      recipientID_ = getDefaultInstance().getRecipientID();
      onChanged();
      return this;
    }
    /**
     * <code>string recipientID = 3;</code>
     * @param value The bytes for recipientID to set.
     * @return This builder for chaining.
     */
    public Builder setRecipientIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      recipientID_ = value;
      onChanged();
      return this;
    }

    private int sequenceID_ ;
    /**
     * <code>int32 sequenceID = 4;</code>
     * @return The sequenceID.
     */
    @java.lang.Override
    public int getSequenceID() {
      return sequenceID_;
    }
    /**
     * <code>int32 sequenceID = 4;</code>
     * @param value The sequenceID to set.
     * @return This builder for chaining.
     */
    public Builder setSequenceID(int value) {
      
      sequenceID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 sequenceID = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearSequenceID() {
      
      sequenceID_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>string content = 5;</code>
     * @return The content.
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        content_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string content = 5;</code>
     * @return The bytes for content.
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string content = 5;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      content_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string content = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      
      content_ = getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    /**
     * <code>string content = 5;</code>
     * @param value The bytes for content to set.
     * @return This builder for chaining.
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      content_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object time_ = "";
    /**
     * <code>string time = 6;</code>
     * @return The time.
     */
    public java.lang.String getTime() {
      java.lang.Object ref = time_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        time_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string time = 6;</code>
     * @return The bytes for time.
     */
    public com.google.protobuf.ByteString
        getTimeBytes() {
      java.lang.Object ref = time_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        time_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string time = 6;</code>
     * @param value The time to set.
     * @return This builder for chaining.
     */
    public Builder setTime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string time = 6;</code>
     * @return This builder for chaining.
     */
    public Builder clearTime() {
      
      time_ = getDefaultInstance().getTime();
      onChanged();
      return this;
    }
    /**
     * <code>string time = 6;</code>
     * @param value The bytes for time to set.
     * @return This builder for chaining.
     */
    public Builder setTimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      time_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ChatMessage)
  }

  // @@protoc_insertion_point(class_scope:ChatMessage)
  private static final com.micolx.connector.protobuf.ChatMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.micolx.connector.protobuf.ChatMessage();
  }

  public static com.micolx.connector.protobuf.ChatMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ChatMessage>
      PARSER = new com.google.protobuf.AbstractParser<ChatMessage>() {
    @java.lang.Override
    public ChatMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ChatMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.micolx.connector.protobuf.ChatMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

