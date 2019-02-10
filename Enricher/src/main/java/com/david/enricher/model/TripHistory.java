/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.david.enricher.model;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TripHistory extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 295644817895186850L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TripHistory\",\"namespace\":\"com.david.enricher.model\",\"fields\":[{\"name\":\"start_date\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"start_station_code\",\"type\":\"int\"},{\"name\":\"end_date\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"end_station_code\",\"type\":\"int\"},{\"name\":\"duration_sec\",\"type\":\"int\"},{\"name\":\"is_member\",\"type\":\"int\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TripHistory> ENCODER =
      new BinaryMessageEncoder<TripHistory>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TripHistory> DECODER =
      new BinaryMessageDecoder<TripHistory>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<TripHistory> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<TripHistory> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TripHistory>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this TripHistory to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a TripHistory from a ByteBuffer. */
  public static TripHistory fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String start_date;
  @Deprecated public int start_station_code;
  @Deprecated public java.lang.String end_date;
  @Deprecated public int end_station_code;
  @Deprecated public int duration_sec;
  @Deprecated public int is_member;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TripHistory() {}

  /**
   * All-args constructor.
   * @param start_date The new value for start_date
   * @param start_station_code The new value for start_station_code
   * @param end_date The new value for end_date
   * @param end_station_code The new value for end_station_code
   * @param duration_sec The new value for duration_sec
   * @param is_member The new value for is_member
   */
  public TripHistory(java.lang.String start_date, java.lang.Integer start_station_code, java.lang.String end_date, java.lang.Integer end_station_code, java.lang.Integer duration_sec, java.lang.Integer is_member) {
    this.start_date = start_date;
    this.start_station_code = start_station_code;
    this.end_date = end_date;
    this.end_station_code = end_station_code;
    this.duration_sec = duration_sec;
    this.is_member = is_member;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return start_date;
    case 1: return start_station_code;
    case 2: return end_date;
    case 3: return end_station_code;
    case 4: return duration_sec;
    case 5: return is_member;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: start_date = (java.lang.String)value$; break;
    case 1: start_station_code = (java.lang.Integer)value$; break;
    case 2: end_date = (java.lang.String)value$; break;
    case 3: end_station_code = (java.lang.Integer)value$; break;
    case 4: duration_sec = (java.lang.Integer)value$; break;
    case 5: is_member = (java.lang.Integer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'start_date' field.
   * @return The value of the 'start_date' field.
   */
  public java.lang.String getStartDate() {
    return start_date;
  }

  /**
   * Sets the value of the 'start_date' field.
   * @param value the value to set.
   */
  public void setStartDate(java.lang.String value) {
    this.start_date = value;
  }

  /**
   * Gets the value of the 'start_station_code' field.
   * @return The value of the 'start_station_code' field.
   */
  public java.lang.Integer getStartStationCode() {
    return start_station_code;
  }

  /**
   * Sets the value of the 'start_station_code' field.
   * @param value the value to set.
   */
  public void setStartStationCode(java.lang.Integer value) {
    this.start_station_code = value;
  }

  /**
   * Gets the value of the 'end_date' field.
   * @return The value of the 'end_date' field.
   */
  public java.lang.String getEndDate() {
    return end_date;
  }

  /**
   * Sets the value of the 'end_date' field.
   * @param value the value to set.
   */
  public void setEndDate(java.lang.String value) {
    this.end_date = value;
  }

  /**
   * Gets the value of the 'end_station_code' field.
   * @return The value of the 'end_station_code' field.
   */
  public java.lang.Integer getEndStationCode() {
    return end_station_code;
  }

  /**
   * Sets the value of the 'end_station_code' field.
   * @param value the value to set.
   */
  public void setEndStationCode(java.lang.Integer value) {
    this.end_station_code = value;
  }

  /**
   * Gets the value of the 'duration_sec' field.
   * @return The value of the 'duration_sec' field.
   */
  public java.lang.Integer getDurationSec() {
    return duration_sec;
  }

  /**
   * Sets the value of the 'duration_sec' field.
   * @param value the value to set.
   */
  public void setDurationSec(java.lang.Integer value) {
    this.duration_sec = value;
  }

  /**
   * Gets the value of the 'is_member' field.
   * @return The value of the 'is_member' field.
   */
  public java.lang.Integer getIsMember() {
    return is_member;
  }

  /**
   * Sets the value of the 'is_member' field.
   * @param value the value to set.
   */
  public void setIsMember(java.lang.Integer value) {
    this.is_member = value;
  }

  /**
   * Creates a new TripHistory RecordBuilder.
   * @return A new TripHistory RecordBuilder
   */
  public static com.david.enricher.model.TripHistory.Builder newBuilder() {
    return new com.david.enricher.model.TripHistory.Builder();
  }

  /**
   * Creates a new TripHistory RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TripHistory RecordBuilder
   */
  public static com.david.enricher.model.TripHistory.Builder newBuilder(com.david.enricher.model.TripHistory.Builder other) {
    return new com.david.enricher.model.TripHistory.Builder(other);
  }

  /**
   * Creates a new TripHistory RecordBuilder by copying an existing TripHistory instance.
   * @param other The existing instance to copy.
   * @return A new TripHistory RecordBuilder
   */
  public static com.david.enricher.model.TripHistory.Builder newBuilder(com.david.enricher.model.TripHistory other) {
    return new com.david.enricher.model.TripHistory.Builder(other);
  }

  /**
   * RecordBuilder for TripHistory instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TripHistory>
    implements org.apache.avro.data.RecordBuilder<TripHistory> {

    private java.lang.String start_date;
    private int start_station_code;
    private java.lang.String end_date;
    private int end_station_code;
    private int duration_sec;
    private int is_member;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.david.enricher.model.TripHistory.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.start_date)) {
        this.start_date = data().deepCopy(fields()[0].schema(), other.start_date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.start_station_code)) {
        this.start_station_code = data().deepCopy(fields()[1].schema(), other.start_station_code);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.end_date)) {
        this.end_date = data().deepCopy(fields()[2].schema(), other.end_date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.end_station_code)) {
        this.end_station_code = data().deepCopy(fields()[3].schema(), other.end_station_code);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.duration_sec)) {
        this.duration_sec = data().deepCopy(fields()[4].schema(), other.duration_sec);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.is_member)) {
        this.is_member = data().deepCopy(fields()[5].schema(), other.is_member);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TripHistory instance
     * @param other The existing instance to copy.
     */
    private Builder(com.david.enricher.model.TripHistory other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.start_date)) {
        this.start_date = data().deepCopy(fields()[0].schema(), other.start_date);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.start_station_code)) {
        this.start_station_code = data().deepCopy(fields()[1].schema(), other.start_station_code);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.end_date)) {
        this.end_date = data().deepCopy(fields()[2].schema(), other.end_date);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.end_station_code)) {
        this.end_station_code = data().deepCopy(fields()[3].schema(), other.end_station_code);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.duration_sec)) {
        this.duration_sec = data().deepCopy(fields()[4].schema(), other.duration_sec);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.is_member)) {
        this.is_member = data().deepCopy(fields()[5].schema(), other.is_member);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'start_date' field.
      * @return The value.
      */
    public java.lang.String getStartDate() {
      return start_date;
    }

    /**
      * Sets the value of the 'start_date' field.
      * @param value The value of 'start_date'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setStartDate(java.lang.String value) {
      validate(fields()[0], value);
      this.start_date = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'start_date' field has been set.
      * @return True if the 'start_date' field has been set, false otherwise.
      */
    public boolean hasStartDate() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'start_date' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearStartDate() {
      start_date = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'start_station_code' field.
      * @return The value.
      */
    public java.lang.Integer getStartStationCode() {
      return start_station_code;
    }

    /**
      * Sets the value of the 'start_station_code' field.
      * @param value The value of 'start_station_code'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setStartStationCode(int value) {
      validate(fields()[1], value);
      this.start_station_code = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'start_station_code' field has been set.
      * @return True if the 'start_station_code' field has been set, false otherwise.
      */
    public boolean hasStartStationCode() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'start_station_code' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearStartStationCode() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'end_date' field.
      * @return The value.
      */
    public java.lang.String getEndDate() {
      return end_date;
    }

    /**
      * Sets the value of the 'end_date' field.
      * @param value The value of 'end_date'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setEndDate(java.lang.String value) {
      validate(fields()[2], value);
      this.end_date = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'end_date' field has been set.
      * @return True if the 'end_date' field has been set, false otherwise.
      */
    public boolean hasEndDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'end_date' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearEndDate() {
      end_date = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'end_station_code' field.
      * @return The value.
      */
    public java.lang.Integer getEndStationCode() {
      return end_station_code;
    }

    /**
      * Sets the value of the 'end_station_code' field.
      * @param value The value of 'end_station_code'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setEndStationCode(int value) {
      validate(fields()[3], value);
      this.end_station_code = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'end_station_code' field has been set.
      * @return True if the 'end_station_code' field has been set, false otherwise.
      */
    public boolean hasEndStationCode() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'end_station_code' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearEndStationCode() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'duration_sec' field.
      * @return The value.
      */
    public java.lang.Integer getDurationSec() {
      return duration_sec;
    }

    /**
      * Sets the value of the 'duration_sec' field.
      * @param value The value of 'duration_sec'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setDurationSec(int value) {
      validate(fields()[4], value);
      this.duration_sec = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'duration_sec' field has been set.
      * @return True if the 'duration_sec' field has been set, false otherwise.
      */
    public boolean hasDurationSec() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'duration_sec' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearDurationSec() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'is_member' field.
      * @return The value.
      */
    public java.lang.Integer getIsMember() {
      return is_member;
    }

    /**
      * Sets the value of the 'is_member' field.
      * @param value The value of 'is_member'.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder setIsMember(int value) {
      validate(fields()[5], value);
      this.is_member = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'is_member' field has been set.
      * @return True if the 'is_member' field has been set, false otherwise.
      */
    public boolean hasIsMember() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'is_member' field.
      * @return This builder.
      */
    public com.david.enricher.model.TripHistory.Builder clearIsMember() {
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TripHistory build() {
      try {
        TripHistory record = new TripHistory();
        record.start_date = fieldSetFlags()[0] ? this.start_date : (java.lang.String) defaultValue(fields()[0]);
        record.start_station_code = fieldSetFlags()[1] ? this.start_station_code : (java.lang.Integer) defaultValue(fields()[1]);
        record.end_date = fieldSetFlags()[2] ? this.end_date : (java.lang.String) defaultValue(fields()[2]);
        record.end_station_code = fieldSetFlags()[3] ? this.end_station_code : (java.lang.Integer) defaultValue(fields()[3]);
        record.duration_sec = fieldSetFlags()[4] ? this.duration_sec : (java.lang.Integer) defaultValue(fields()[4]);
        record.is_member = fieldSetFlags()[5] ? this.is_member : (java.lang.Integer) defaultValue(fields()[5]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TripHistory>
    WRITER$ = (org.apache.avro.io.DatumWriter<TripHistory>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TripHistory>
    READER$ = (org.apache.avro.io.DatumReader<TripHistory>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
