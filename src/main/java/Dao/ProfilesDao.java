package Dao;

import domain.Profile;

/**
 * Created by Eoller on 03-May-18.
 */
public class ProfilesDao extends AbstractDao<Profile> {

    public ProfilesDao() {
        super(Profile.class);
    }

    public static void main(String[] args) {
        ProfilesDao profilesDao = new ProfilesDao();
        System.out.println(profilesDao.getById(2).getLanguagesByLanguageId().getName());
    }
}
