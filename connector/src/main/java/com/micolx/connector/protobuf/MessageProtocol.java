// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: MessageProtocol.proto

package com.micolx.connector.protobuf;

public final class MessageProtocol {
  private MessageProtocol() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChatMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AckMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AckMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GreetMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GreetMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025MessageProtocol.proto\"v\n\013ChatMessage\022\r" +
      "\n\005msgID\030\001 \001(\t\022\020\n\010senderID\030\002 \001(\t\022\023\n\013recip" +
      "ientID\030\003 \001(\t\022\022\n\nsequenceID\030\004 \001(\005\022\017\n\007cont" +
      "ent\030\005 \001(\t\022\014\n\004time\030\006 \001(\t\"H\n\nAckMessage\022\r\n" +
      "\005msgID\030\001 \001(\t\022\023\n\013recipientID\030\002 \001(\t\022\026\n\004typ" +
      "e\030\003 \001(\0162\010.AckType\",\n\014GreetMessage\022\016\n\006use" +
      "rId\030\001 \001(\t\022\014\n\004time\030\003 \001(\t*+\n\007AckType\022\010\n\004SE" +
      "NT\020\000\022\014\n\010RECEIVED\020\001\022\010\n\004READ\020\002B!\n\035com.mico" +
      "lx.connector.protobufP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChatMessage_descriptor,
        new java.lang.String[] { "MsgID", "SenderID", "RecipientID", "SequenceID", "Content", "Time", });
    internal_static_AckMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_AckMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AckMessage_descriptor,
        new java.lang.String[] { "MsgID", "RecipientID", "Type", });
    internal_static_GreetMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_GreetMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GreetMessage_descriptor,
        new java.lang.String[] { "UserId", "Time", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
