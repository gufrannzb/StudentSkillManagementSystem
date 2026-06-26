
package com.skillmanager.service;

import com.skillmanager.model.CertificateVerification;

import java.util.List;
import com.skillmanager.model.Certificate;

/**
 *
 * @author mohdgufran
 */

import com.skillmanager.dao.CertificateDAO;

public class CertificateService {

    CertificateDAO certificateDAO =
            new CertificateDAO();

    // SAVE CERTIFICATE

    public boolean saveCertificate(
            int userId,
            int skillId,
            double percentage,
            String certificateCode) {

        return certificateDAO
                .saveCertificate(
                        userId,
                        skillId,
                        percentage,
                        certificateCode);

    }

    // CHECK CERTIFICATE EXISTS

    public boolean certificateExists(
            String certificateCode) {

        return certificateDAO
                .certificateExists(
                        certificateCode);

    }
    
    public CertificateVerification
    getCertificateByCode(
        String certificateCode) {

    return certificateDAO
            .getCertificateByCode(
                    certificateCode);
}
    
    public String getCertificateCode(
        int userId,
        int skillId) {

    return certificateDAO
            .getCertificateCode(
                    userId,
                    skillId);
    
    
}
    
    public List<Certificate>
getCertificatesByUserId(
        int userId) {

    return certificateDAO
            .getCertificatesByUserId(
                    userId);
}

public List<Certificate>
getAllCertificates() {

    return certificateDAO
            .getAllCertificates();
}

public boolean deleteCertificate(
        int certificateId) {

    return certificateDAO
            .deleteCertificate(
                    certificateId);
}

public int getTotalCertificates() {

    return certificateDAO
            .getAllCertificates()
            .size();
}

}