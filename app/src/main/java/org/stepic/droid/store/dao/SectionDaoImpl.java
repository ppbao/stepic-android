package org.stepic.droid.store.dao;

import android.content.ContentValues;
import android.content.Context;

import org.stepic.droid.model.Section;
import org.stepic.droid.store.structure.DbStructureSections;
import org.stepic.droid.util.DbParseHelper;

public class SectionDaoImpl extends DaoBase implements Dao<Section> {
    public SectionDaoImpl(Context context) {
        super(context);
    }

    @Override
    public void insertOrUpdate(Section section) {
        ContentValues values = new ContentValues();

        values.put(DbStructureSections.Column.SECTION_ID, section.getId());
        values.put(DbStructureSections.Column.TITLE, section.getTitle());
        values.put(DbStructureSections.Column.SLUG, section.getSlug());
        values.put(DbStructureSections.Column.IS_ACTIVE, section.is_active());
        values.put(DbStructureSections.Column.BEGIN_DATE, section.getBegin_date());
        values.put(DbStructureSections.Column.SOFT_DEADLINE, section.getSoft_deadline());
        values.put(DbStructureSections.Column.HARD_DEADLINE, section.getHard_deadline());
        values.put(DbStructureSections.Column.COURSE, section.getCourse());
        values.put(DbStructureSections.Column.POSITION, section.getPosition());
        values.put(DbStructureSections.Column.UNITS, DbParseHelper.parseLongArrayToString(section.getUnits()));

        super.insertOrUpdate(DbStructureSections.SECTIONS, values, DbStructureSections.Column.SECTION_ID, section.getId() + "");
    }

    @Override
    public boolean isInDb(Section persistentObject) {
        return super.isInDb(DbStructureSections.SECTIONS, DbStructureSections.Column.SECTION_ID, persistentObject.getId() + "");
    }
}
